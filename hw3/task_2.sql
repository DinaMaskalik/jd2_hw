select expenses.num,expenses.paydate, receivers.rname, expenses.payvalue
from expenses
inner join receivers on receivers.num=expenses.receiver_num
where expenses.payvalue>10000;