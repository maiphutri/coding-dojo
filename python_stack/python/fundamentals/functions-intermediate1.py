import random
def randInt(min=0, max=100):
  if max < 0:
    return False
  if min > max:
    temp = min
    min = max
    max = temp
  num = random.random() * (max - min) + min
  return round(num)
print(randInt())
print(randInt(max=50))
print(randInt(min=50))
print(randInt(min=50, max=500))
print(randInt(min=10, max=5))
print(randInt(max= -1))