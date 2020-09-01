# draper-test
### Admin Logins
| username | password |
|----------|----------|
| davemd | admin1 |
| mattknighten | rolltide |

### Tables/Beans
1. Customer
2. Account
3. Transaction
4. Login

### Customer Fields/Columns
1. customerid - a serial primary key
2. firstname
3. lastname

### Account Fields/Columns
1. accountid - a serial primary key
2. balance
3. customerid - a foreign key linking to the customer who holds the account

### Transaction Fields/Columns
1. transactionid - a serial primary key
2. transactiontype - Deposit or Withdrawal
3. amount
4. accountid - a foreign key linking to the account that holds the transaction

### Login Fields/Columns
1. username - a varchar primary key
2. password
3. usertype - Admin or Customer
4 customerid - a foreign key linking to the customer being logged into (if a Customer type entry)
