package dao.jpa;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class BooleanAttributeConverter implements AttributeConverter<Boolean, Character> {

	@Override
	public Character convertToDatabaseColumn(Boolean bool) {
		return bool ? 'T' : 'F';
	}

	@Override
	public Boolean convertToEntityAttribute(Character c) {
		return c == 'T';
	}

}
