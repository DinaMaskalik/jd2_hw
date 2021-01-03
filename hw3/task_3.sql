set SQL_SAFE_UPDATES=0;

delete from expenses
where expenses.payvalue<3000;


select expenses.num,expenses.paydate, receivers.rname, expenses.payvalue
from expenses
inner join receivers on receivers.num=expenses.receiver_num; 