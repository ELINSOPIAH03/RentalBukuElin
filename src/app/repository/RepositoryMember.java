package app.repository;

import app.member.Member;

import java.util.ArrayList;
import java.util.List;

public class RepositoryMember {
    public static List<Member> getAllMembers() {
        List<Member> members = new ArrayList<>();
        // Tambahkan data member dummy
        members.add(new Member("M-001", "Risman", "Bandung"));
        members.add(new Member("M-002", "Budi", "Bandung"));
        members.add(new Member("M-003", "Resti", "Kab. Bandung"));
        
        return members;
    }
}
