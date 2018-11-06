package com.landlord.android.repositories;

import com.landlord.android.http.HttpRequester;
import com.landlord.android.models.ChatMessage;
import com.landlord.android.models.Estate;
import com.landlord.android.parsers.base.JsonParser;
import com.landlord.android.repositories.base.Repository;

import java.io.IOException;
import java.util.List;

public class HttpRepository<T> implements Repository<T> {
    private final HttpRequester mHttpRequester;
    private final String mServerUrl;
    private final JsonParser<T> mJsonParser;

    public HttpRepository(
            String serverUrl,
            HttpRequester httpRequester,
            JsonParser<T> jsonParser

    ) {
        mServerUrl = serverUrl;
        mHttpRequester = httpRequester;
        mJsonParser = jsonParser;
    }

    @Override
    public List<T> getAll() throws IOException {
        String jsonArray = mHttpRequester.get(mServerUrl);
        return mJsonParser.fromJsonArray(jsonArray);
    }

    @Override
    public List<T> getEstatesByUser(String userName) throws IOException {
        String url = mServerUrl + "/Estates/User/" + userName;
        String jsonArray = mHttpRequester.get(url);
        return mJsonParser.fromJsonArray(jsonArray);
    }

    @Override
    public T getEstateByID(int estateID) throws IOException {
        String url = mServerUrl + "/Estates/ID/" + estateID;
        String json = mHttpRequester.get(url);
        return mJsonParser.fromJson(json);
    }


    @Override
    public T add(T item) throws IOException {
        String requestBody = mJsonParser.toJson(item);
        String responseBody = mHttpRequester.post(mServerUrl, requestBody);
        return mJsonParser.fromJson(responseBody);
    }

    @Override
    public T getById(int id) throws IOException {
        String url = mServerUrl + "/" + id;
        String json = mHttpRequester.get(url);
        return mJsonParser.fromJson(json);
    }

    @Override
    public List<T> getMessagesByEstate(String estateName) throws IOException {
        String url = mServerUrl + "/Messages/Estate/" + estateName;
        String jsonArray = mHttpRequester.get(url);
        return mJsonParser.fromJsonArray(jsonArray);
    }
}
