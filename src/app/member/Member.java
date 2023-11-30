package app.member;

public class Member {
    String memberID;
    String memberName;
    String address;

    public Member(String memberID, String memberName, String address) {
        this.memberID = memberID;
        this.memberName = memberName;
        this.address = address;
    }

    // Getter methods for Member attributes
    public String getMemberID() {
        return memberID;
    }

    public String getMemberName() {
        return memberName;
    }

    public String getAddress() {
        return address;
    }

    // Setter methods for Member attributes
    public void setMemberID(String memberID) {
        this.memberID = memberID;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Member{" +
                "memberID='" + memberID + '\'' +
                ", memberName='" + memberName + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
