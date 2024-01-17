def gcd(a, b):
    while b != 0:
        a, b = b, a % b
    return a

# Read the input
a, b = map(int, input().split())

# Compute the GCD
result = gcd(a, b)

# Print the result
print(result)
