# pythagorean triplets

# Group all square numbers until 1000^2

# subset_sum problem

i = 1 
square_numbers = []
# while i*i <= 1000000:
# 	square_numbers.append(i*i)
# 	i = i +1

for i in range(1, 1001):
	square_numbers.append(i*i)

print("Total square numbers until 1000^2: {}".format(len(square_numbers)))
print(square_numbers)


