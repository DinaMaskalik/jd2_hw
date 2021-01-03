select max(payvalue)
from (
select d.pay, max(d.amount)
from (select expenses.paydate as pay, SUM(payvalue) as amount 
		from expenses 
		GROUP BY paydate) as d) as s, expenses
where paydate=s.pay;