package com.kyle.erp.group.bbs;

import java.io.File;
import java.math.BigDecimal;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kyle.erp.member.Member;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@Service
public class BBSDAO {
	private int allBBSCount;

	@Autowired
	private SqlSession ss;

	public void deleteBBSMsg(BBS bm, HttpServletRequest req,HttpServletResponse res) {
		try {
			BBS bm2 = ss.getMapper(BBSMapper.class).getBBSMsg(bm);
			if (ss.getMapper(BBSMapper.class).deleteBBSMsg(bm) == 1) {
				allBBSCount--;

				String b_img = bm2.getB_img();
				b_img = URLDecoder.decode(b_img, "utf-8");
				String path = req.getSession().getServletContext().getRealPath("resources/file");
				File f = new File(path + "/" + b_img);
				f.delete();
				
				if (req.getSession().getAttribute("searchMsgs") != null) {
					String b_owner = (String) req.getSession().getAttribute("searchMsgsOwner");
					searchBBSMsg(new BBS(null, b_owner,null,null, null, null, null, null, null, null), req);
				}
			}
		} catch (Exception e) {
		}
	}

	public void deleteBBSReply(BBSReply br, HttpServletRequest req,HttpServletResponse res) {
		try {
			if (ss.getMapper(BBSMapper.class).deleteBBSReply(br) == 1) {
			}
		} catch (Exception e) {
		}
	}

	public void getAllMsgsCount(HttpServletRequest req,HttpServletResponse res) {
		allBBSCount = ss.getMapper(BBSMapper.class).getAllBBSMsgsCount();
	}

	public void setPage(int pageNo, HttpServletRequest req) {
		req.getSession().setAttribute("pageNo", pageNo);
	}

	public void paging(HttpServletRequest req) {
		@SuppressWarnings("unchecked")
		List<BBS> searchMsgs = (List<BBS>) req.getSession().getAttribute("searchMsgs");

		Integer pageNo = (Integer) req.getSession().getAttribute("pageNo");
		if (pageNo == null) {
			pageNo = 1;
		}

		double count = 5.0;
		req.setAttribute("curPage", pageNo);

		if (searchMsgs != null && searchMsgs.size() > 0) {
			int pageCount = (int) Math.ceil(searchMsgs.size() / count);
			req.setAttribute("pageCount", pageCount);

			int start = (searchMsgs.size() - ((pageNo - 1) * (int) count));
			int end = (pageNo == pageCount) ? 1 : (start - ((int) count - 1));

			ArrayList<BBS> msgs = new ArrayList<BBS>();
			BBS bm = null;

			for (int i = start - 1; i >= end - 1; i--) {
				bm = searchMsgs.get(i);
				bm.setB_reply(ss.getMapper(BBSMapper.class).getBBSReplys(bm));
				msgs.add(bm);
			}
			req.setAttribute("msgs", msgs);
		} else if (allBBSCount > 0) {
			int pageCount = (int) Math.ceil(allBBSCount / count);
			req.setAttribute("pageCount", pageCount);
			int start = (allBBSCount - ((pageNo - 1) * (int) count));
			int end = (pageNo == pageCount) ? 1 : (start - ((int) count - 1));
			BBSNo bmn = new BBSNo(new BigDecimal(start), new BigDecimal(end));
			List<BBS> msgs = ss.getMapper(BBSMapper.class).getBBSMsgs(bmn);
			for (BBS bm : msgs) {
				bm.setB_reply(ss.getMapper(BBSMapper.class).getBBSReplys(bm));
			}
			req.setAttribute("msgs", msgs);
		}
	}

	public void searchClear(HttpServletRequest req) {
		req.getSession().setAttribute("searchMsgs", null);
	}

	public void searchBBSMsg(BBS bm, HttpServletRequest req) {
		req.getSession().setAttribute("searchMsgsOwner", bm.getB_owner());
		req.getSession().setAttribute("searchMsgs", ss.getMapper(BBSMapper.class).searchBBSMsg(bm));
	}

	public void updateBBSMsg(BBS bm, HttpServletRequest req) {
		try {
			if (ss.getMapper(BBSMapper.class).updateBBSMsg(bm) == 1) {
				if (req.getSession().getAttribute("searchMsgs") != null) {
					String b_owner = (String) req.getSession().getAttribute("searchMsgsOwner");
					searchBBSMsg(new BBS(null, b_owner, null,null,null, null, null, null, null, null), req);
				}
			}
		} catch (Exception e) {
		}
	}

	public void writeBBSMsg(BBS bm, HttpServletRequest req) {
		MultipartRequest mr = null;
		String path = req.getSession().getServletContext().getRealPath("resources/file");
		try {
			mr = new MultipartRequest(req, path, 50 * 1024 * 1024, "utf-8", new DefaultFileRenamePolicy());
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}

		try {
			Member m = (Member) req.getSession().getAttribute("loginMember");
			bm.setB_owner(m.getM_id());
			bm.setB_type(mr.getParameter("b_type"));
			String b_title = mr.getParameter("b_title");
			if (b_title.equals("")) {
				b_title = "x";
			} else {
				b_title = b_title.replace("\r\n", "<br>");
			}
			bm.setB_title(b_title);
			
			String b_txt = mr.getParameter("b_txt");
			if (b_txt.equals("")) {
				b_txt = "x";
			} else {
				b_txt = b_txt.replace("\r\n", "<br>");
			}
			bm.setB_txt(b_txt);

			String b_img = mr.getFilesystemName("b_img");
			if (b_img == null) {
				b_img = "x";
			} else {
				b_img = URLEncoder.encode(b_img, "utf-8");
				b_img = b_img.replace("+", " ");
			}
			bm.setB_img(b_img);

			if (ss.getMapper(BBSMapper.class).writeBBSMsg(bm) == 1) {
				allBBSCount++;
			}
		} catch (Exception e) {
			e.printStackTrace();
			File f = new File(path + "/" + mr.getFilesystemName("b_img"));
			f.delete();
		}
	}

	public void writeBBSReply(BBSReply br, HttpServletRequest req) {
		try {
			Member m = (Member) req.getSession().getAttribute("loginMember");
			br.setBr_owner(m.getM_id());
			if (ss.getMapper(BBSMapper.class).writeBBSReply(br) == 1) {
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	
}
