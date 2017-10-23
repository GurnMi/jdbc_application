-- db 존재하면 삭제
drop database if exists coffee_project;

-- db 생성
create database coffee_project;

-- db 사용
use coffee_project;

drop table menu;

drop table cInput;

drop table cOutput;
-- 커피테이블
CREATE TABLE if not exists coffee_project.menu (
    cNo char(11) ,
    cName char(10),
    PRIMARY KEY (cNo)
);
delete from menu where cno="A001";

CREATE TABLE if not exists coffee_project.cInput (
    cNo char(11) ,
    cPrice int(10),
    Volume int(20),
    Margin int(20),
    PRIMARY KEY (cNo),
	foreign key (cNo) references menu(cNo)
	on delete cascade
);

CREATE TABLE if not exists coffee_project.cOutput (
    cNo char(11) ,
    cPrice int(10),
    Volume int(20),
    Supply int(20),
    tax int(20),
    Amount int(20),
    Margin int(20),
    MarginPrice int(20),
    PRIMARY KEY (cNo),
    foreign key (cNo) references menu(cNo)
);


insert into menu values
("A001","아메리카노"),
("A002","카푸치노"),
("A003","헤이즐넛"),
("A004","에스프레소"),
("B001","딸기쉐이크"),
("B002","후르추와인"),
("B003","팥빙수"),
("B004","아이스초코");

select*from cInput;
select*from menu;
select*from cOutput;

insert into cInput values
("A001", 4500,150,10),
("A002", 3800,140,15),
("B001", 5200,250,12),
("B002", 4300,110,11);

/*insert into cInput values
("B003", 5200,250,12);*/

insert into cInput values
("A001","아메리카노", 4500,150,10),
("A002","카푸치노", 3800,140,15),
("B001","딸기쉐이크", 5200,250,12),
("B002","후르추와인", 4300,110,11);

/*(cNo, cName, Price, Volume, Supply, tax, Amount, Margin, MarginPice)*/
/*
DELIMITER $$
create trigger insert_sales
	after insert
	on cInput
	for each row
	begin insert into cOutput (cNo, cName, Price, Volume, Supply, tax, Amount, Margin, MarginPice)
	values (cInput.cNo, cInput.cName, cInput.Price, cInput.Volume, cInput.Price*cInput.volume*89/100, cInput.Price*cInput.volume*11/100, cInput.Price*cInput.volume, cInput.Margin, cInput.Price*cInput.volume*cInput.Margin/100);
DELIMITER ;


create view cIutput1 as
select cNo, cName,cPrice, volume, Margin
from cInput i join menu m on i.cNo=m.mNo;

select*from cIutput1;


create view cOutput1 as
select cNo, cName, Price, Volume, Supply, tax, Amount, Margin, MarginPice
from cInput i join menu m on i.cNo=m.mNo
values cInput.cNo, menu.cName, cInput.Price, cInput.Volume, cInput.Price*cInput.volume*89/100, cInput.Price*cInput.volume*11/100, cInput.Price*cInput.volume, cInput.Margin, cInput.Price*cInput.volume*cInput.Margin/100;


DELIMITER $$
	create trigger cIutput_1
	after insert
	on cInput
	select into cInput_1(cNo, cName,cPrice, volume, Margin)
	values from cInput i join menu m on i.cNo=m.mNo;
DELIMITER ;

drop trigger insert_sales;

DELIMITER $$
create trigger insert_sales
	after insert
	on cOutput
	for each row
	begin 
		insert into cIutput (cNo, cName, Price, Volume, Supply, tax, Amount, Margin, MarginPice)
		set cInput i join menu m on i.cNo=m.mNo
		values (cInput.cNo, m.cName, cInput.Price, cInput.Volume, cInput.Price*cInput.volume*89/100, cInput.Price*cInput.volume*11/100, cInput.Price*cInput.volume, cInput.Margin, cInput.Price*cInput.volume*cInput.Margin/100);
	end
DELIMITER ;
*/

DELIMITER $$
create trigger insert_sales
	after insert
	on cinput
	for each row
	begin 
		insert into cOutput values
		(new.cNo, 
		new.cPrice,
		new.Volume,
		(new.cPrice*new.Volume)-ceiling((new.cPrice*new.Volume)/11), 
		ceiling(new.cPrice*new.Volume)/11,
		new.cPrice*new.Volume, 
		new.Margin,
		round(((new.cPrice*new.Volume)-ceiling((new.cPrice*new.Volume)/11))*new.Margin/100)
		);
	end
DELIMITER ;

drop trigger insert_sales;




create view cIutput1 as
select i.cNo, cName, cPrice, volume, Margin
from cInput i join menu m on i.cNo=m.cNo;

select*from result1;
select*from result2;

create view result1 
	as select (select count(*)+1 from coutput where Supply>o.Supply)  as crank,
			o.cNo, cName, cPrice, volume, Supply, tax, Amount,Margin, MarginPrice 
from cOutput o join menu m on o.cNo = m.cNo order by Supply desc; 

create view result2
	as select (select count(*)+1 from coutput where MarginPrice>o.MarginPrice)  as crank,
			o.cNo, cName, cPrice, volume, Supply, tax, Amount,Margin, MarginPrice 
from cOutput o join menu m on o.cNo = m.cNo order by MarginPrice desc; 


/*select count(*)+1 from coutput where Supply>T.cOutput as '순위'
from */

delete from cInput;

show triggers from insert_sales;

select cName from cInput i join menu m on i.cNo=m.mNo;

select*from menu;
select*from cOutput;
select*from cInput;