def bubble_sort_while(arr):
  swap = True

  while swap == True:
    swap = False
    for i in range(len(arr)-1):
      if arr[i] > arr[i+1]:
        arr[i], arr[i+1] = arr[i+1], arr[i]
        swap = True

  return arr

print(bubble_sort_while([5,2,1,4,3]))

def bubble_sort_for(arr):
  index = 0
  for i in range(index,len(arr)):
    for j in range(index+1, len(arr)):
      if arr[i] > arr[j]:
        arr[i], arr[j] = arr[j], arr[i]
    index += 1
  return arr

print(bubble_sort_for([5,2,1,4,3]))

    
