select rname, (select sum(expenses.payvalue)
							from expenses
                            where expenses.receiver_num=r.num) as 'Sum'
from receivers r;