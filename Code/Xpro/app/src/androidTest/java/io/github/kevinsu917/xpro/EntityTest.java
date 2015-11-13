package io.github.kevinsu917.xpro;

import android.test.AndroidTestCase;

import junit.framework.Assert;

import java.util.ArrayList;

import io.github.kevinsu917.xpro.common.entity.Student;
import io.github.kevinsu917.xpro.common.entity.Teacher;
import io.github.kevinsu917.xpro.common.entity.User;

/**
 * Creator: KevinSu kevinsu917@126.com
 * Date 2015-11-09-11:08
 * Description:
 */
public class EntityTest extends AndroidTestCase {

    public void testUser(){

        ArrayList<User> userList = new ArrayList<>();

        Teacher teacher1 = new Teacher();
        teacher1.setType(1);
        teacher1.setUsername("t1_name");
        teacher1.setPassword("t1_password");
        teacher1.setTeacherStr("t1_str");
        userList.add(teacher1);

        Student student1 = new Student();
        student1.setType(2);
        student1.setUsername("s1_name");
        student1.setPassword("s1_password");
        student1.setStudentStr("s1_str");
        userList.add(student1);


        User user1 = userList.get(0);
        User user2 = userList.get(1);

        Teacher t = (Teacher) user1;
        Assert.assertEquals(teacher1.getTeacherStr(), t.getTeacherStr());

    }
}
