package com.AIRetail.Service;

import java.util.Set;
import org.springframework.stereotype.Service;
import com.AIRetail.Entity.UserEntity;

public interface UserManagerService {
	public UserEntity createUser(UserEntity user); //�����˻�
	public void deleteUser(Integer userId);//ͨ���û�IDɾ����Ӧ�û�
	public void changePassword(Integer userId, String newPassword);//�޸�����
	public UserEntity findByUsername(String userlabel);// �����û��������û�
	public UserEntity findByUserId(Integer userlabel);// �����û��������û�
	public Integer getRankIdById(Integer userId);//ͨ���û�ID���rankid
	public Set<UserEntity> getUsersByRankid(Integer rankid);//ͨ��rankid��ö�Ӧ���û�
	public Set<String> getRoles(Integer userId);//ͨ���û�ID����û���ɫ
}
