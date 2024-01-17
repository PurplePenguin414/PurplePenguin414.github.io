# Function to calculate the number of distinct cities in a test case
def count_distinct_cities(trips):
    return len(set(trips))

# Main function
def main():
    T = int(input())  # Number of test cases

    for _ in range(T):
        n = int(input())  # Number of work trips
        trips = []
        for _ in range(n):
            city = input().strip()
            trips.append(city)

        distinct_cities = count_distinct_cities(trips)
        print(distinct_cities)

if __name__ == "__main__":
    main()
