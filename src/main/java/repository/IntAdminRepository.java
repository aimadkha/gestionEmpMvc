package repository;

import org.springframework.stereotype.Repository;

@Repository
public interface IntAdminRepository {
	public boolean checkAdmin(String email, String password);
}
