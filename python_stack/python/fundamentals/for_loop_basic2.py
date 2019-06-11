# Biggie Size
def biggie_size(arr):
  for i in range(len(arr)):
    if arr[i] > 0:
      arr[i] = "big"
  return arr
print(biggie_size([-1,3,5,-5]))

# Count Positives
def count_positives(arr):
  count = 0;
  for e in arr:
    if e > 0:
      count += 1
  arr[len(arr)-1] = count
  return arr
print(count_positives([-1,1,1,1]))
print(count_positives([1,6,-4,-2,-7,-2]))

# Sum Total
def sum_total(arr):
  sum = 0
  for e in arr:
    sum += e
  return sum
print(sum_total([1,2,3,4]))
print(sum_total([6,3,-2]))

# Average
def average(arr):
  sum = 0
  for e in arr:
    sum += e
  return sum / len(arr)
print(average([1,2,3,4]))

# Length
def length(arr):
  count = 0
  for e in arr:
    count += 1
  return count
print(length([37,2,1,-9]))
print(length([]))

# Minimum
def minimum(arr):
  if len(arr) < 1:
    return False

  min = arr[0]

  for i in range(1, len(arr)):
    if arr[i] < min:
      min = arr[i]
  return min
print(minimum([37,2,1,-9]))
print(minimum([]))

# Maximum
def maximum(arr):
  if len(arr) < 1:
    return False

  max = arr[0]

  for i in range(1, len(arr)):
    if arr[i] > max:
      max = arr[i]
  return max
print(maximum([37,2,1,-9]))
print(maximum([]))

# Ultimate Analysis
def ultimate_analysis(arr):
  new_dict = {
    'sumTotal': 0,
    'average': 0,
    'minimum': 0
  }
  for e in arr:
    new_dict['sumTotal'] += e
    if e < new_dict['minimum']:
      new_dict['minimum'] = e
  new_dict['average'] = new_dict['sumTotal'] / len(arr)
  return new_dict
print(ultimate_analysis([37,2,1,-9]))

# Reverse List
def reverse_list(arr):
  for i in range(len(arr) // 2):
    temp = arr[i]
    arr[i] = arr[len(arr) - 1]
    arr[len(arr) - 1] = temp
  return arr
print(reverse_list([37,2,1,-9]))
