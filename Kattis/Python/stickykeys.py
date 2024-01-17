def correct_message(message):
    corrected_message = ""
    previous_char = ""

    for char in message:
        if char != previous_char:
            corrected_message += char
            previous_char = char

    return corrected_message

# Read the input message
message = input()

# Correct the message by removing consecutive duplicates
corrected_message = correct_message(message)

# Output the corrected message
print(corrected_message)
