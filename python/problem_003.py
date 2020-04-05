# Largest Prime Factor

from primes import get_primes
from math import sqrt

N = 600851475143
n = int(sqrt(N))

pr = get_primes(n)
i = len(pr) - 1

while i > 0:

	if N%pr[i] == 0:
		print(pr[i])
		break

	i -= 1

