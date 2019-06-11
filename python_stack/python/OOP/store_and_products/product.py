class Products:
  def __init__(self, id, name, price, category):
    self.id = id
    self.name = name
    self.price = price
    self.category = category
  
  def update_price(self, percent_change, is_increased):
    if is_increased == True:
      self.price += self.price * percent_change
    if is_increased == False:
      self.price -= self.price * percent_change
    return self
