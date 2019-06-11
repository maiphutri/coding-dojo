#1
def a():
  return 5
print(a())
# Predict: print 5
# Output: print 5

#2
def a():
    return 5
print(a()+a())
# Predict: print 10
# Output: print 10

#3
def a():
    return 5
    return 10
print(a())
# Predict: print 5
# Output: prnt 5

#4
def a():
    return 5
    print(10)
print(a())
# Predict: print 5
# Output: print 5

#5
def a():
    print(5)
x = a()
print(x)
# Predict: print 5, return None
# Output: print 5, return None

#6
# def a(b,c):
#     print(b+c)
# print(a(1,2) + a(2,3))
# # Predict: print 3, 5, error
# # Output: print 3, 5, error

#7
def a(b,c):
    return str(b) + str(c)
print(a(2,5))
# Predict: print "25"
# Output: print "25"

#8
def a():
    b = 100
    print(b)
    if b < 10:
        return 5
    else:
        return 10
    return 7
print(a())
# Predict: print 100, 10
# Output: print 100, 10

#9
def a(b,c):
    if b<c:
        return 7
    else:
        return 14
    return 3
print(a(2,3))
print(a(5,3))
print(a(2,3) + a(5,3))
# Predict: print 7, 14, 21
# Output: print 7, 14, 21

#10
def a(b,c):
    return b + c
    return 10
print(a(3,5))
# Predict: print 8
# Output: print 8

#11
b = 500
print(b)
def a():
    b = 300
    print(b)
print(b)
a()
print(b)
# Predict: print 500, 500, 300, 500
# Output: print 500, 500, 300, 500

#12
b = 500
print(b)
def a():
    b = 300
    print(b)
    return b
print(b)
a()
print(b)
# Predict: print 500, 500, 300, 300
# Output: print 500, 500, 300, 300

#13
b = 500
print(b)
def a():
    b = 300
    print(b)
    return b
print(b)
b=a()
print(b)
# Predict: print 500, 500, 300, 300
# Output: print 500, 500, 300, 300

#14
def a():
    print(1)
    b()
    print(2)
def b():
    print(3)
a()
# Predict: print 1, 3, 2
# Output: print 1, 3, 2

#15
def a():
    print(1)
    x = b()
    print(x)
    return 10
def b():
    print(3)
    return 5
y = a()
print(y)
# Predict: print 1, 3, 5, 10
# Output: print 1, 3, 5, 10