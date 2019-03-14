create table erp_customer(
	tbl_no number(5)primary key,
	cus_no varchar2(12 char)not null,
	cus_name varchar2(30 char)not null,
	cus_regno varchar2(20 char)not null,
	cus_owner varchar2(50 char)not null,
	cus_addr varchar2(100 char)not null,
	cus_division number(5)not null,
	cus_note varchar2(2048 char)not null
);
create sequence erp_customer_seq;
select * from ERP_CUSTOMER;
select * from erp_customer where cus_no like '%||cus03||%'
insert into erp_customer values(erp_customer_seq.nextval,'cus_no','cus_name','cus_regno','cus_owner','cus_addr',1,'scscsc');

-- --------------------------------------
create table erp_product(
	tbl_no number(5)primary key,
	pro_no varchar2(12 char)not null,
	pro_name varchar2(30 char)not null,
	pro_unit varchar2(20 char)not null,
	pro_weight number(5)not null,
	pro_buy number(5)not null,
	pro_sell number(5)not null,
	pro_note varchar2(2048 char)not null
);
create sequence erp_product_seq;
select * from erp_product;
-- --------------------------------------
create table erp_container(
	con_no varchar2(12 char)not null,
	con_name varchar2(30 char)not null,
	con_note varchar2(2048 char)not null
);
drop table erp_container cascade constraint;
-- --------------------------------------
create table erp_currency(
	cur_no varchar2(12 char)not null,
	cur_name varchar2(30 char)not null,
	cur_note varchar2(2048 char)not null
);
drop table erp_currency cascade constraint;
-- --------------------------------------
create table erp_sales(
	s_no number(5)primary key,
	s_date date not null,
	s_cus varchar2(120 char),
	s_m_id varchar2(200 char),
	s_con varchar2(120 char),
	s_cur varchar2(120 char),
	s_type varchar2(100 char),
	s_pro_no varchar2(120 char),
	s_qty number(10),
	s_pro_price number(10,2),
	s_price number(10,2),
	s_tax number(10),
	s_sum number(10,2)
);
create sequence erp_sales_seq;
select * from erp_sales;
drop table erp_sales cascade constraint;
-- --------------------------------------
create table erp_division(
	d_no number(5)not null,
	d_inout number(5)not null,
	d_note varchar2(20 char)not null
);
-- --------------------------------------
create table erp_member(
	m_id varchar2(20 char)primary key,
	m_pw varchar2(20 char)not null,
	m_name varchar2(20 char)not null,
	m_email varchar2(40 char)not null,
	m_addr varchar2(100 char)not null,
	m_photo varchar2(150 char)not null
);
select * from erp_member;
-- --------------------------------------
create table ex7_3(
	emp_id number(5),
	emp_name varchar2(100)
);
select * from ex7_3;
insert into ex7_3 values(101,'홍길동');		-- 단일 insert
insert all												-- 다중 insert
	into ex7_3 values(105,'가가가')
	into ex7_4 values(106,'나나나')
select * from dual;

truncate table ex7_3;
truncate table ex7_4;

insert all
	when department_id =30 then
		into ex7_3 values (employee_id,emp_name)
	when department_id = 90 then
		into ex7_4 values (employee_id,emp_name)
select department_id,employee_id,emp_name from employees;
	


-- --------------------------------------
create table ex7_4(
	emp_id number(5),
	emp_name varchar2(100)
);
select * from ex7_4;


desc erp_member;




