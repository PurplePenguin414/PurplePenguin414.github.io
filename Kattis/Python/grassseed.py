# Function to calculate the cost for each lawn
def calculate_lawn_cost(width, length, C):
    return width * length * C

def main():
    C = float(input())  # Cost of seed per square meter
    L = int(input())    # Number of lawns to sow
    total_cost = 0.0    # Initialize total cost

    for _ in range(L):
        width, length = map(float, input().split())
        lawn_cost = calculate_lawn_cost(width, length, C)
        total_cost += lawn_cost

    # Output the total cost with 8 decimal places precision
    print(format(total_cost, ".8f"))

if __name__ == "__main__":
    main()
