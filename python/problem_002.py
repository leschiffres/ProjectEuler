a = 1
b = 2

total = 2
while b < 4000000:
# while b < 100:
	c = a+b
	a = b
	b = c
	if c % 2 == 0:
		total += c

print(total)