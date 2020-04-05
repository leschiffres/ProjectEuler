import math

def get_primes(n):

	is_prime = [True for _ in range(n)]

	i = 2
	while i < math.sqrt(n):
		if is_prime[i]:
			
			curr_num = i+i
			while curr_num < n:

				is_prime[curr_num] = False
				curr_num += i

		i += 1
		
	return [i for i in range(n) if is_prime[i]]

# print(get_primes(100))
