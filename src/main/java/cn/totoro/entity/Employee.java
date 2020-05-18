package cn.totoro.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 *   `ID` int(11) NOT NULL AUTO_INCREMENT,
 *   `DEPT_ID` int(11) NOT NULL,
 *   `JOB_ID` int(11) NOT NULL,
 *   `NAME` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
 *   `CARD_ID` varchar(18) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
 *   `ADDRESS` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
 *   `POST_CODE` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
 *   `TEL` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
 *   `PHONE` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
 *   `QQ_NUM` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
 *   `EMAIL` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
 *   `SEX` int(11) NOT NULL DEFAULT 1,
 *   `PARTY` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
 *   `BIRTHDAY` datetime(0) NULL DEFAULT NULL,
 *   `RACE` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
 *   `EDUCATION` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
 *   `SPECIALITY` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
 *   `HOBBY` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
 *   `REMARK` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
 *   `CREATE_DATE` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0),
 */
public class Employee {

    private Integer id;
    @NotNull(message = "部门ID不能为空")
    private Dept dept;
    @NotNull(message = "职位ID不能为空")
    private Job job;
    @NotNull(message = "名称不能为空")
    private String name;
    @NotNull(message = "卡号不能为空")
    private String cardId;
    @NotNull(message = "地址不能为空")
    private String address;
    private String postCode;
    private String tel;
    @NotNull(message = "手机号不能为空")
    private String phone;
    private Integer qqNum;
    @NotNull(message = "邮箱不能为空")
    private String email;
    @NotNull(message = "性别不能为空")
    private Integer sex;
    private String party;
    private Date birthday;
    private String race;
    private String education;
    private String speciality;
    private String hobby;
    private String remark;
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    @NotNull(message = "添加时间不能为空")
    private Date createDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Dept getDept() {
        return dept;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getQqNum() {
        return qqNum;
    }

    public void setQqNum(Integer qqNum) {
        this.qqNum = qqNum;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getParty() {
        return party;
    }

    public void setParty(String party) {
        this.party = party;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String deucation) {
        this.education = deucation;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", dept=" + dept +
                ", job=" + job +
                ", name='" + name + '\'' +
                ", cardId='" + cardId + '\'' +
                ", address='" + address + '\'' +
                ", postCode='" + postCode + '\'' +
                ", tel='" + tel + '\'' +
                ", phone='" + phone + '\'' +
                ", qqNum=" + qqNum +
                ", email='" + email + '\'' +
                ", sex=" + sex +
                ", party='" + party + '\'' +
                ", birthday=" + birthday +
                ", race='" + race + '\'' +
                ", deucation='" + education + '\'' +
                ", speciality='" + speciality + '\'' +
                ", hobby='" + hobby + '\'' +
                ", remark='" + remark + '\'' +
                ", createDate=" + createDate +
                '}';
    }
}
