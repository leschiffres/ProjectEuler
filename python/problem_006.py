sum_of_squares = 0

square_of_sum = 0

for i in range(1,100+1):

	sum_of_squares += i*i
	square_of_sum +=i

square_of_sum = square_of_sum**2

print(f"Sum of squares: {sum_of_squares}")
print(f"Square of sum: {square_of_sum}")

diff = square_of_sum - sum_of_squares
print(f"Difference: {diff}")