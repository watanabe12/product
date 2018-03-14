package com.internousdev.template.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.internousdev.template.dto.LoginDTO;
import com.internousdev.template.util.DBConnector;

public class LoginDAO {

	private DBConnector dbConnector = new DBConnector();
	private Connection connection = dbConnector.getConnection();
	private LoginDTO loginDTO = new LoginDTO();
	/* ログインユーザ情報取得メソッド
	 * @param loginUserId
	 * @param loginPassword
	 * @return LoginDTO */
	public LoginDTO getLoginUserInfo(String loginUserId, String loginPassword) {
		/*PreparedStatementを使う場合は、
		まずSQL文の中にクエスチョンマーク（？）の形で
		パラメータを埋め込んで仮のSQL文を作ります*/
		String sql = "SELECT * FROM login_user_transaction where login_id = ? AND login_pass = ?";

		try {
			/*仮のSQL文をConnectionクラスの
			prepareStatementメソッドに与えて
			PreparedStatementオブジェクトを生成します。*/
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			//仮に"？"を入れておいたパラメータに実際の値を割り当てます。
			preparedStatement.setString(1, loginUserId);
			preparedStatement.setString(2, loginPassword);
			
			/*SELECT文などの問い合わせ文を送信する場合に使われ
			ResultSetオブジェクトに実行結果を格納して返す
			SQL文の実行結果が何も返さなかった場合でも、
			nullを 返すことはなく、空のResultSetオブジェクトを返す。*/
			ResultSet resultSet = preparedStatement.executeQuery();

			 /*クエリ結果を1レコードずつ
			Select文でDBから取得した情報をDTOクラスに格納。*/
			if (resultSet.next()) {
				//ResultSetを利用すれば、問い合わせで得られたデータにアクセス可能。
				loginDTO.setLoginId(resultSet.getString("login_id"));
				loginDTO.setLoginPassword(resultSet.getString("login_pass"));
				loginDTO.setUserName(resultSet.getString("user_name"));

				if (!(resultSet.getString("login_id").equals(null))) {
					loginDTO.setLoginFlg(true);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return loginDTO;
	}

	public LoginDTO getLoginDTO() {
		return loginDTO;
	}
}