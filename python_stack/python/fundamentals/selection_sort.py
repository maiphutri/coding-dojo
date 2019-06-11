def selection_sort(arr):
  for i in range(len(arr)-1):
    min = arr[i]
    index = i
    for j in range(i, len(arr)):
      if arr[j] < min:
        min = arr[j]
        index = j
    arr[i], arr[index] = arr[index], arr[i]

  return arr

print(selection_sort([5,1,4,3,2]))