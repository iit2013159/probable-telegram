public enum Tags {
    Husband_Name("Husband Name"),
    Wife_Name("Wife Name"),
    Category("Category"),
    Aadhar_belongs("Aadhar belongs"),
    Aadhar_Number("Aadhar Number"),
    Mobile_number("Mobile number"),
    Account_belongs_to("Account belongs to"),
    Account_number("Account number"),
    IFSC("IFSC"),
    Child("Child"),
    Child_age("Child age"),
    Child_gender("Child gender"),
    Is_connected_with_AW("Is connected with AWD"),
    Other("Other");
    // enum constructor - cannot be public or protected

    // declaring private variable for getting values
    private String action;

    private Tags(String action)
    {
        this.action = action;
    }

    // getter method
    public String getAction()
    {
        return this.action;
    }

}
