package com.spring.service;

import org.springframework.stereotype.Service;

import com.spring.model.Citizen;

@Service

public class CitizenService {

	public Citizen processCitizen(Citizen citizen) {

		if (citizen.getSSN() != null && !citizen.getSSN().isEmpty()) {

			char ssnFirstDigit = citizen.getSSN().charAt(0);

			String state = getStateFromSSN(ssnFirstDigit);

			citizen.setStateName(state);

		} else {

			citizen.setStateName("Invalid SSN");

		}

		return citizen;

	}

	private String getStateFromSSN(char ssnFirstDigit) {

		switch (ssnFirstDigit) {

		case '1':

			return "New Jersey";

		case '2':

			return "Ohio";

		case '3':

			return "Texas";

		case '4':

			return "California";

		case '5':

			return "Rhode Island";

		case '6':

			return "Kentucky";

		default:

			return "Unknown";

		}

	}

}
