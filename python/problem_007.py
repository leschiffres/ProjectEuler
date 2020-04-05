from primes import get_primes
from time import time

print(get_primes(10))
start = time()
n = 1000000
prime_numbers = get_primes(n)
print(f"{len(prime_numbers)} total prime numbers under {n}")
print(f"{prime_numbers[10002]} is the 10001-st prime number")


print(f"Total execution time: {round(time()-start, 2)}")