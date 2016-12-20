package quanlidetaikhoahoc.domain;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

public class YeuCauSerializer extends StdSerializer<YeuCauDuyetDeTai> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public YeuCauSerializer() {
		this(null);
	}

	public YeuCauSerializer(Class<YeuCauDuyetDeTai> t) {
		super(t);
	}

	@Override
	public void serialize(YeuCauDuyetDeTai value, JsonGenerator gen, SerializerProvider provider) throws IOException {

		String tenDeTai = value.getDeTai().getTen();
		int length = tenDeTai.length() > 50 ? 50 : tenDeTai.length();
		gen.writeStartObject();
		gen.writeNumberField("id", value.getId());
		gen.writeNumberField("idDeTai", value.getDeTai().getIdDeTai());
		gen.writeStringField("tenDeTai", tenDeTai.substring(0, length));
		gen.writeStringField("tenNguoiDung", value.getNguoiDung().getTenTacGia());
		gen.writeStringField("thoiGianTao", value.getThoiGianTao().toString());
		gen.writeEndObject();
	}

}
