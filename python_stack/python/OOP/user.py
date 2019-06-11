class User:
  def __init__(self, username, email):
    self.username = username
    self.email = email
    self.account1 = BankAccount(int_rate=0.02)
    self.account2 = BankAccount()
  
  def make_deposit(self, amount, account="account1"):
    if account == "account1":
      self.account1.balance += amount
    else:
      self.account2.balance += amount
    return self
  
  def make_withdrawal(self, amount, account="account1"):
    if account == "account1":
      if amount > self.account1.balance:
        return False
      self.account1.balance -= amount
    else:
      if amount > self.account2.balance:
        return False
      self.account2.balance -= amount
    return self
  
  def display_user_balance(self, account="account1"):
      print(f"User: {self.username}, Balance-Account-1: ${self.account1.balance}")
      print(f"User: {self.username}, Balance-Acoount-2: ${self.account2.balance}")

  def transfer_money(self, other_user, amount, account="account1"):
    if account == "account1":
      self.account1.balance -= amount
      other_user.make_deposit(amount)
    else:
      self.account2.balance -= amount
      other_user.make_deposit(amount)
    return self

class BankAccount:
  def __init__(self, int_rate=0.01, balance=0):
    self.int_rate = int_rate
    self.balance = balance
  
  def yield_interest(self):
    if self.balance > 0:
      self.balance +=  self.balance * self.int_rate
      return self

user1 = User("John", "John@test.com")
user2 = User("Mike", "Mike@test.com")
user3 = User("Lena", "Lena@test.com")

user1.make_deposit(1000).make_deposit(500, "account2").make_deposit(700).make_withdrawal(300).display_user_balance()

user2.make_deposit(500).make_deposit(1500, "account2").make_withdrawal(100).make_withdrawal(200, "account2").display_user_balance()

user3.make_deposit(1000).make_withdrawal(100).make_withdrawal(200).make_withdrawal(700).display_user_balance()

user2.transfer_money(user3, 200, "account2").display_user_balance()
user3.display_user_balance()