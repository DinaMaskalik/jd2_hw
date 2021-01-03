create database if not exists ListExpenses;

create table if not exists ListExpenses.receivers(
	num int not null primary key,
    rname varchar(255) not null
);

create table if not exists ListExpenses.expenses (
	num int not null primary key,
    paydate date not null,
    receiver_num int not null,
	payvalue dec,
    constraint receiver_num 
		foreign key(receiver_num)
        references ListExpenses.receivers(num)
);
