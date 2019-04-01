create table erp_customer(
	cus_no varchar2(20 char)primary key,
	cus_name varchar2(30 char)not null,
	cus_regno varchar2(20 char),
	cus_owner varchar2(50 char),
	cus_addr varchar2(100 char),
	cus_division varchar2(20 char),
	cus_email varchar2(50 char),
	cus_note varchar2(2048 char)
);
create sequence erp_customer_seq;
-- --------------------------------------
create table erp_product(
	pro_no varchar2(100 char)primary key,
	pro_name varchar2(30 char)not null,
	pro_unit varchar2(20 char)not null,
	pro_buy number(5),
	pro_sell number(5),
	pro_weight number(5,2),
	pro_hscode varchar2(30 char),
	pro_note varchar2(2048 char)
);
create sequence erp_product_seq;
-- --------------------------------------
create table erp_container(
	con_no varchar2(12 char)not null,
	con_name varchar2(30 char)not null,
	con_note varchar2(2048 char)not null
);
select * from ERP_CONTAINER
create sequence erp_container_seq;
-- --------------------------------------
create table erp_currency(
	cur_no varchar2(12 char)not null,
	cur_name varchar2(30 char)not null,
	cur_money number(10,2)not null,
	cur_note varchar2(2048 char)
);
create sequence erp_currency_seq;
-- --------------------------------------
create table erp_sales(
	s_no number(5)primary key,
	s_d_no number(5)not null,
	s_date date not null,
	s_cus varchar2(120 char),
	s_m_id varchar2(200 char),
	s_con varchar2(120 char),
	s_cur varchar2(120 char),
	s_type varchar2(100 char),
	s_note varchar2(2048 char)
);
create sequence erp_sales_seq;
-- --------------------------------------
create table erp_sub_sales(
	sb_no number(5)primary key,
	sb_s_no number(5)not null,
	sb_pro_no varchar2(120 char),
	sb_qty number(10),
	sb_pro_price number(10,2),
	sb_price number(10,2),
	sb_tax number(10),
	sb_sum number(10,2)
);
alter table erp_sub_sales add constraint erp_sub_sales_const foreign key(sb_s_no) references erp_sales(s_no) on delete cascade;
create sequence erp_sub_sales_seq;
-- --------------------------------------
create table erp_purchase(
	ps_no number(5)primary key,
	ps_d_no number(5)not null,
	ps_date date not null,
	ps_cus varchar2(120 char),
	ps_m_id varchar2(200 char),
	ps_con varchar2(120 char),
	ps_cur varchar2(120 char),
	ps_type varchar2(100 char),
	ps_note varchar2(2048 char)
);
create sequence erp_purchase_seq;
drop table erp_purchase cascade constraint;
-- --------------------------------------
create table erp_sub_purchase(
	psb_no number(5)primary key,
	psb_s_no number(5)not null,
	psb_pro_no varchar2(120 char),
	psb_qty number(10),
	psb_pro_price number(10,2),
	psb_price number(10,2),
	psb_tax number(10),
	psb_sum number(10,2)
);
alter table erp_sub_purchase add constraint erp_sub_purchase_const foreign key(psb_s_no) references erp_purchase(ps_no) on delete cascade;
create sequence erp_sub_purchase_seq;
drop table erp_sub_purchase cascade constraint;
-- --------------------------------------
create table erp_bbs(
	b_no number(5)primary key,
	b_owner varchar2(20 char),
	b_type varchar2(20 char),
	b_title varchar2(100 char),
	b_txt varchar2(2048 char),
	b_date date,
	b_img varchar2(1000 char)
);
create sequence erp_bbs_seq;
drop table erp_bbs cascade constraint;
drop table erp_bbs_reply cascade constraint;
-- --------------------------------------
create table erp_bbs_reply(
	br_no number(5)primary key,
	br_b_no number(5)not null,
	br_owner varchar2(20 char),
	br_txt varchar2(2048 char),
	br_date date
);
create sequence erp_bbs_reply_seq;
alter table erp_bbs_reply add constraint erp_bbs_reply_const foreign key(br_b_no) references erp_bbs(b_no) on delete cascade;
-- --------------------------------------
create table erp_company(
	com_key	number(5)primary key,
	com_name varchar2(30 char),
	com_no varchar2(20 char),
	com_email varchar2(100 char),
	com_tel varchar2(20 char),
	com_addr varchar2(100 char),
	com_logo varchar2(100 char),
	com_ename varchar2(30 char),
	com_etel varchar2(20 char),
	com_eaddr varchar2(100 char)
);
create sequence erp_company_seq;
-- --------------------------------------
create table erp_division(
	d_no number(5)not null,
	d_inout number(5)not null,
	d_note varchar2(20 char)not null
);
-- --------------------------------------
create table erp_member(
	m_id varchar2(20 char)primary key,
	m_code number(5),
	m_pw varchar2(20 char)not null,
	m_name varchar2(20 char),
	m_email varchar2(40 char),
	m_addr varchar2(100 char),
	m_photo varchar2(150 char)
);
-- --------------------------------------
create table erp_authority(
	auth_key number(5)primary key,
	auth_name varchar2(20 char)
);
select * from erp_authority;
insert into erp_authority values (1,'기본 권한')
insert into erp_authority values (2,'구매 승인')
insert into erp_authority values (3,'MASTER')
-- --------------------------------------
create table erp_member_auth(
	m_id varchar2(20 char)primary key,
	auth_key number(5)
);
alter table erp_member_auth add constraint erp_member_auth_const foreign key(auth_key) references erp_authority(auth_key) on delete cascade;
alter table erp_member_auth add constraint erp_member_auth_m_id foreign key(m_id) references erp_member;

select erp_member.m_id,m_name,m_email,auth_key from (erp_member inner join erp_member_auth on erp_member_auth.m_id = erp_member.m_id) where m_code = 1
select erp_member.m_id,m_name,m_email,auth_name from erp_member,erp_member_auth,erp_authority where erp_member.m_id = erp_member_auth.m_id and erp_member_auth.auth_key = erp_authority.auth_key and m_code =1; 
insert into erp_member_auth values('test',3);
insert into erp_member_auth values('member1',1);

