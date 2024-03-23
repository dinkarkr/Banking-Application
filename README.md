# Banking-Application
This repository contains a banking application built using SpringBoot, allowing users to perform various operations such as creating an account, getting account details, deleting an account, withdrawing funds, and depositing funds. 
The Application leverages SpringBoot's powerful features for rapid development and includes RESTful APIs for seamless integration with other systems. Explore the codebase to understand how springBooot can be used to build robust banking applications.

Please refer below endpoints for performing the operations:-

deleteAccount: perform delete request using postman with endpoint => http://localhost:8080/api/accounts/2 -> where 2 is id

CreateAccount: perform post request using postman with endpoint => http://localhost:8080/api/accounts
Body: - {
    "id":2,
    "accountHolderName":"Dinkar",
    "Balance":50000
}

GetAccount Details: perform get request using postman with endpoint => http://localhost:8080/api/accounts/1 -> where 1 is id

GetAllAccount in bank: perform get request using postman with endpoint => http://localhost:8080/api/accounts
above operation will return you all the accounts present in list.

Deposit: perform put request using postman with endpoint => http://localhost:8080/api/accounts/2/deposit
Body : - {
    "amount":30000
}

Withdraw: perform put request using postman with endpoint => http://localhost:8080/api/accounts/1/withdraw
Body : - {
    "amount":3000
}
