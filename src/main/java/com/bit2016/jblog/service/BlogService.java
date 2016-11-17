package com.bit2016.jblog.service;

import java.io.FileOutputStream;
import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.bit2016.jblog.repository.BlogDao;
import com.bit2016.jblog.vo.BlogVo;
import com.bit2016.jblog.vo.CategoryVo;
import com.bit2016.jblog.vo.UserVo;

@Service
public class BlogService {
	private static final String SAVE_PATH = "/upload";

	@Autowired
	private BlogDao blogDao;

	public BlogVo index(Long no) {
		return blogDao.index(no);
	}

	// ************************ 기본 수정 ******************************
	public void basicModify(BlogVo blogVo, MultipartFile file, String blogName) {

		blogVo.setTitle(blogName);

		try {
			if (file.isEmpty() == true) {
				blogDao.onlyTitle(blogVo);

			}
			String originalName = file.getOriginalFilename();
			String extName = originalName.substring(originalName.lastIndexOf('.') + 1, originalName.length());
			String saveName = generateSaveName(extName);
			writeFile(file, saveName);

			blogVo.setLogo(saveName);

		} catch (Exception e) {
			throw new RuntimeException("upload file");
		}
		blogDao.basicModify(blogVo);

	}

	public void onlyTitle(BlogVo blogVo) {

		blogDao.onlyTitle(blogVo);
	}

	public String generateSaveName(String extName) {
		String fileName = "";
		Calendar calendar = Calendar.getInstance();

		fileName += calendar.get(Calendar.YEAR);
		fileName += calendar.get(Calendar.MONTH);
		fileName += calendar.get(Calendar.DATE);
		fileName += calendar.get(Calendar.HOUR);
		fileName += calendar.get(Calendar.MINUTE);
		fileName += calendar.get(Calendar.SECOND);
		fileName += ("." + extName);

		return fileName;
	}

	private void writeFile(MultipartFile multipartFile, String saveName) throws Exception {

		byte[] fileData = multipartFile.getBytes();
		FileOutputStream fos = new FileOutputStream(SAVE_PATH + "/" + saveName);

		fos.write(fileData);
	}
	// ************************ 카테고리 수정 *******************************

	public void add_category(UserVo authUser, String categoryName, CategoryVo categoryVo, String description) {
		
		categoryVo.setUsers_no(authUser.getNo());
		categoryVo.setName(categoryName);
		categoryVo.setDescription(description);

		blogDao.add_category(categoryVo);
	}

	public void delete_category(CategoryVo categoryVo,Long no,Long userNo) {
		categoryVo.setUsers_no(userNo);
		categoryVo.setNo(no);
		
		blogDao.delete_category(categoryVo);
	}
}
