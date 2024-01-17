import math

def calculate_ladder_length(h, v):
    # Convert angle from degrees to radians
    angle_in_radians = math.radians(v)

    # Calculate the length of the ladder using trigonometry
    ladder_length = h / math.sin(angle_in_radians)

    return ladder_length

def main():
    # Input: Read two integers h and v
    h, v = map(int, input().split())

    # Calculate the length of the ladder
    length = calculate_ladder_length(h, v)

    # Output: Print the length of the ladder
    print(int(math.ceil(length)))

if __name__ == "__main__":
    main()
