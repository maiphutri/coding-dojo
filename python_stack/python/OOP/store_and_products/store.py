import product
Products = product.Products

class Store:
  def __init__(self, name):
    self.name = name
    self.product_list = []
  
  def add_product(self, new_product):
    self.product_list.append(new_product)
    return self
  
  def sell_product(self, id):
    for item in self.product_list:
      if (id == item.id):
        self.product_list.pop(self.product_list.index(item))
    return self
    
  
  def inflation(self, percent_increase):
    for item in self.product_list:
      item.update_price(percent_increase, True)
    return self
  
  def set_clearance(self, category, percent_discount):
    for item in self.product_list:
      if item.category == category:
        item.update_price(percent_discount, False)
    return self
  
  def display_products(self):
    for item in self.product_list:
      print(f"Product: {item.name}, Category: {item.category}, Price: ${item.price}")

iphone = Products(1,'iphone', 1099, 'electronics')
tv = Products(2, 'tv', 1999, 'electronics')
burger = Products(3, 'burger', 10, 'foods')
coke = Products(4, 'coke', 2, 'drinks')
  
bjs_restaurant = Store('Bjs')
best_buy = Store('Best Buy')

best_buy.add_product(iphone).add_product(tv).display_products()
bjs_restaurant.add_product(burger).add_product(coke).display_products()

# bjs_restaurant.inflation(0.02).display_products()
# best_buy.set_clearance(category='electronics', percent_discount=0.5).display_products()

bjs_restaurant.sell_product(3).display_products()
