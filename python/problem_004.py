def is_palindrome(n):
	s = str(n)
	s_reverse = s[len(s)::-1]
	return s == s_reverse

palindromes = []

a = 999
while a > 500: 
	b = 999
	while b > 100:
		c = a*b
		if is_palindrome(c):
			palindromes.append(c)
			# print(f"{a} * {b} = {c}")
			break;
		b = b -1
	a = a - 1

print(max(palindromes))
