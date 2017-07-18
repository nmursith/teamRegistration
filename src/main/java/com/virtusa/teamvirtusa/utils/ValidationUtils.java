package com.virtusa.teamvirtusa.utils;


import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class ValidationUtils {
	public static void main(String []args){
		System.out.println(new ValidationUtils().validateVirtusaEmailId("me@virtusapolaris.com"));
		System.out.println(new ValidationUtils().validateVirtusaEmailId("me@gmail.com"));
	}

    public boolean validateYesNo(String answer){
        if(answer.equals("Y") || answer.equals("N")){
            return true;
        }
        return false;
    }
    
    public boolean validateMaritalStatus(String status){
        if(status.equals("MARRIED") || status.equals("SINGLE")){
            return true;
        }
        return false;
    }

	public boolean validateSex(String sex) {
        if(sex.equals("MALE") || sex.equals("FEMALE")){
            return true;
        }
        return false;
	}

	public boolean validateSsn(String ssn) {
		return ssn.matches("\\d{3}-\\d{2}-\\d{4}");
	}

/*	public boolean validateOrganizationType(String type) {
		try {
			EnumOrganizationType.valueOf(type);
			return true;
		 } catch (IllegalArgumentException e) { 
			return false;		 
		 }
	}

	public boolean validatePhoneNumberType(String type) {
		try {
			EnumPhoneNumberType.valueOf(type);
			return true;
		 } catch (IllegalArgumentException e) { 
			return false;		 
		 }
	}*/

	public boolean validatePhoneNumber(String phoneNumber) {
		String regex = "^(1\\-)?[0-9]{3}\\-?[0-9]{3}\\-?[0-9]{4}$";
		return phoneNumber.matches(regex);
	}

	public boolean validateTitle(String title) {
        if(title.equals("MR") || title.equals("MRS") || title.equals("MISS") || title.equals("MASTER") || title.equals("")){
            return true;
        }
        return false;
	}

	public boolean validateVirtusaEmailId(String emailId) {
		String regex = "(?<=@)[^.]+(?=\\.)";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(emailId);
		String domain ="";

		if(matcher.find()) {
			domain = emailId.substring(matcher.start() );
			//System.out.println(domain);
			if (domain.equals("virtusapolaris.com")) {
				return true;
			}
		}
		return  false;

	}

	public boolean validateEmailId(String emailId) {
		String regex = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(emailId);
		return matcher.matches();
	}

/*
	public boolean validatePhoneAdressType(String type) {
		try {
			EnumAddressType.valueOf(type);
			return true;
		 } catch (IllegalArgumentException e) { 
			return false;		 
		 }
	}
*/

	public boolean validateZipCode(String zipCode) {
		String regex = "^[0-9]{5}(?:-[0-9]{4})?$";
		return zipCode.matches(regex);
	}
	
/*	public boolean validateAccountStatus(String type) {
		try {
				EnumAccountStatus.valueOf(type);
				return true;
			 } catch (IllegalArgumentException e) { 
				return false;		 
			 }
	}
	*/
/*	public boolean validateRtpTokenType(String type) {
		try {
				EnumRtpTokenType.valueOf(type);
				return true;
			 } catch (IllegalArgumentException e) { 
				return false;		 
			 }
	}*/
	
	public boolean validateRoutingNumber(String routingNumber) {
		return routingNumber.matches("\\d{9}");
	}
	
	public boolean validateExpiryDate(java.sql.Date date){

		return date.before(new Date());
	}
	
/*	public boolean validateVirtualWalletAccount(List<Account> accountList){
		int total_vw_accounts =0;
		if(accountList.size() >=3){

			for (Account account: accountList) {
				if(account.getAccountType().getAccountType().equals("VIRTUAL_WALLET_SPEND") ||
						account.getAccountType().getAccountType().equals("VIRTUAL_WALLET_RESERVE") ||
						account.getAccountType().getAccountType().equals("VIRTUAL_WALLET_GROWTH")
						)
				{
					total_vw_accounts+=1;
				}

			}

			if(total_vw_accounts==3)
				return true;
		}
		return false;

	}*/

}
