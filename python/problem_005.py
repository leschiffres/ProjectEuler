# least common multiple
# https://en.wikipedia.org/wiki/Least_common_multiple

# using simple algorithm. Create  list with all the numbers and every time multiply with the lowest

# Reverse this algorithm

# iteratively divide all elements with the smallest number in the list that is not one. 
# the algorithm ends when all elements are equal to one.
# e.g. 
# [3, 4, 9] : divide with 3
# [1, 4, 3] : divide with 3
# [1, 4, 1] : divide with 4
# [1, 1, 1] : end of algorithm
# lcm: 3*3*4 = 36

# get the minimum element of the list not equal to one
def get_min_not_one(x):
	m = max(x)
	for i in x:
		if  1 < i < m:
			m = i
	return m

x = [i+1 for i in range(20)]
print(x)
lcm = 1
while True:
	m = get_min_not_one(x)

	if m != 1:
		lcm = lcm * m
		print(m)
		for i in range(len(x)):
			if x[i] % m == 0:
				x[i] = x[i]//m
	else:
		break

	print(x)

print(lcm)