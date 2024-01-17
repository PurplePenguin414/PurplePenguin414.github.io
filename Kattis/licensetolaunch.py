# Read the input
total_days = int(input())
space_junk = list(map(int, input().split()))

# Find the minimum space junk count and its index
min_junk = min(space_junk)
min_index = space_junk.index(min_junk)

# Output the number of days to wait
days_to_wait = min_index 
print(days_to_wait)
