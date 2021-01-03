select sum(payvalue)
from expenses
inner join receivers on receivers.num=expenses.receiver_num
where paydate=(select paydate
		from expenses
        where expenses.payvalue=(select max(payvalue)
									from expenses));