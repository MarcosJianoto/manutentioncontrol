package com.manutentioncontrol.entities;

import java.time.LocalDate;

public enum MaintenanceUnit {

	DAYS {

		public LocalDate addToDate(LocalDate date, Integer amount) {
			return date.plusDays(amount);
		}

	},

	MONTHS {
		public LocalDate addToDate(LocalDate date, Integer amount) {
			return date.plusMonths(amount);
		}

	},

	YEARS {
		public LocalDate addToDate(LocalDate date, Integer amount) {
			return date.plusYears(amount);
		}

	};

	public abstract LocalDate addToDate(LocalDate date, Integer amount);

}
