# Count Down
def count_down(num):
  arr = []
  for i in range(num, -1, -1):
    arr.append(i)
  return arr
print(count_down(5))

# Print and Return
def print_and_return(arr):
  print(arr[0])
  return arr[1]
print(print_and_return([1,2]))

# First Plus Length
def first_plus_length(arr):
  return arr[0] + len(arr)
print(first_plus_length([1,2,3,4,5]))

# Values Greater than Second
def values_greater_than_second(arr):
  if len(arr) < 2:
    return False
  new_arr = []
  count = 0
  for i in range(len(arr)):
    if arr[i] > arr[1]:
      new_arr.append(arr[i])
      count += 1
  print("Count:", count)
  return new_arr
print(values_greater_than_second([5,2,3,2,1,4]))
print(values_greater_than_second([4]))

# This Length, That Value
def length_and_value(size, value):
  arr = []
  for i in range(size):
    arr.append(value)
  return arr
print(length_and_value(4,7))
print(length_and_value(6,2))
