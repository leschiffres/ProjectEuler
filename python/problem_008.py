def product(nums):
	total = 1
	for n in nums:
		total *= int(n)

	return total


with open("input_problem008.txt") as f:
	nums = f.readlines()[0]
 

max_mult = 1
for i in range(13, len(nums)):
	curr_mult = product(nums[(i-13):i])
	if curr_mult > max_mult:
		max_mult = curr_mult
		if max_mult == 23514624000:
			print(f"Maximum product sequence: {nums[(i-13):i]}")
print(max_mult)


