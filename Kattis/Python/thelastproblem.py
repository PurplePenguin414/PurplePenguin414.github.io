def farewell_message(name):
    return f"Thank you, {name}, and farewell!"

def main():
    # Input: Read a single string representing the name
    name = input().strip()

    # Output: Print the farewell message
    print(farewell_message(name))

if __name__ == "__main__":
    main()
