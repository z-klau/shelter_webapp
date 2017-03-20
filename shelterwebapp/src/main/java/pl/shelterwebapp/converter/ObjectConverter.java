package pl.shelterwebapp.converter;

import java.util.ArrayList;
import java.util.Collection;

public interface ObjectConverter<F, T> {

	T convert(F from);

	default Collection<T> convert(Collection<F> from) {
		Collection<T> convertedList = new ArrayList<>();
		from.forEach(o -> convertedList.add(convert(o)));
		return convertedList;
	}
}
