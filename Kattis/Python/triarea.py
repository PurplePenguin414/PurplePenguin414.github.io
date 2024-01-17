def calculate_triangle_area(height, base):
    area = 0.5 * height * base
    return area

def main():
    # Input: Read two integers representing height and base
    height, base = map(int, input().split())

    # Calculate the area of the triangular cake
    area = calculate_triangle_area(height, base)

    # Output: Print the area
    print(area)

if __name__ == "__main__":
    main()
